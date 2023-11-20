package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;
import com.example.demo.repository.AtmDao;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	private AtmDao atmDao;

	@Override
	public AtmResponse addInfo(String account, String pwd) {

		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		if (atmDao.existsById(account)) {
			return new AtmResponse(null, RtnCode.ACCOUNT_EXISTED);
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd)));
		// 不想回傳pwd
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse getBalanceByAccount(String account, String pwd) {
		if (!StringUtils.hasText(account)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) { // 帳號
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		Atm res = op.get();
		BCryptPasswordEncoder econder = new BCryptPasswordEncoder();
		if (!econder.matches(pwd, res.getPwd())) { // 密碼
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);

	}

	@Override
	public AtmResponse updatePwd(String account, String oldPwd, String newPwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(oldPwd) || !StringUtils.hasText(newPwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		Atm res = op.get();
		BCryptPasswordEncoder econder = new BCryptPasswordEncoder();
		if (!econder.matches(oldPwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		res.setPwd(econder.encode(newPwd));
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse deposit(String account, String pwd, int amount) {

		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || amount <= 0) { // 檢查帳號密碼
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		Optional<Atm> op = atmDao.findById(account); 	// 帳號是否存在
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		Atm res = op.get();
		BCryptPasswordEncoder econder = new BCryptPasswordEncoder();
		if (!econder.matches(pwd, res.getPwd())) { 					// 密碼
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		res.setBalance(res.getBalance() + amount);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse withdraw(String account, String pwd, int amount) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || amount <= 0) { // 檢查帳號密碼有沒有內容
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		Optional<Atm> op = atmDao.findById(account); // 帳號是否存在
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}

		Atm res = op.get();
		BCryptPasswordEncoder econder = new BCryptPasswordEncoder();
		if (!econder.matches(pwd, res.getPwd())) { 					// 比對密碼格式
			return new AtmResponse(null, RtnCode.ACCOUNT_NOT_FOUND);
		}
		// 檢查餘額大於提款金額
		if (res.getBalance() < amount) {
			res.setPwd("");
			return new AtmResponse(res, RtnCode.INSUFFCIENT_BALANCE);
		}
		res.setBalance(res.getBalance() - amount);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

}
