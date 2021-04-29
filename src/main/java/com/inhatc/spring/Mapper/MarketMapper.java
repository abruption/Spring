package com.inhatc.spring.Mapper;

import com.inhatc.spring.DTO.MemberDto;

public interface MarketMapper {

    int processAddMember(MemberDto dto) throws Exception;
    MemberDto processLoginMember(MemberDto dto) throws Exception;
}
