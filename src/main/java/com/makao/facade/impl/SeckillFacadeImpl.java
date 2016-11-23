package com.makao.facade.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makao.dto.Exposer;
import com.makao.dto.SeckillExecution;
import com.makao.entity.Seckill;
import com.makao.exception.RepeatKillException;
import com.makao.exception.SeckillCloseException;
import com.makao.exception.SeckillException;
import com.makao.facade.SeckillFacade;
import com.makao.service.SeckillService;

/**
 * @author ZYR
 * dubbo接口实现
 */
@Service
public class SeckillFacadeImpl implements SeckillFacade {
	private Log LOG = LogFactory.getLog(this.getClass());

    @Autowired
    private SeckillService seckillService;
    
	@Override
	public List<Seckill> getSeckillList() {
		return seckillService.getSeckillList();
	}

	@Override
	public Seckill getById(long seckillId) {
		return seckillService.getById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		return seckillService.exportSeckillUrl(seckillId);
	}

	@Override
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		return seckillService.executeSeckill(seckillId, userPhone, md5);
	}

	@Override
	public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5) {
		return seckillService.executeSeckillProcedure(seckillId, userPhone, md5);
	}

}
