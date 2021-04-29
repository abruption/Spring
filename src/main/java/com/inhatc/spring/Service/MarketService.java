package com.inhatc.spring.Service;

import com.inhatc.spring.DTO.MemberDto;
import com.inhatc.spring.Mapper.MarketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {
    @Autowired
    MarketMapper marketMapper;

    public int processAddMember(MemberDto dto) throws Exception {
        return marketMapper.processAddMember(dto);
    }

    public MemberDto processLoginMember(MemberDto dto) throws Exception{
        return marketMapper.processLoginMember(dto);
    }
}
