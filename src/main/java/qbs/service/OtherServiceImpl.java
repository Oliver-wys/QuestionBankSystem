package qbs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import qbs.domain.Other;
import qbs.mapper.JudgeMapper;

@Controller
@Transactional
public class OtherServiceImpl implements IOtherService {

	@Autowired
	JudgeMapper judgeMapper;
	
	@Override
	public List<Other> findAll() {
		// TODO Auto-generated method stub
		return judgeMapper.findAll();
	}

}
