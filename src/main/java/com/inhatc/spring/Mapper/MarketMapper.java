package com.inhatc.spring.Mapper;

import com.inhatc.spring.DTO.MemberDto;

public interface MarketMapper {

    int processAddMember(MemberDto dto) throws Exception;
    MemberDto processLoginMember(MemberDto dto) throws Exception;
    MemberDto processMemberInfo(MemberDto dto) throws Exception;
    int processUpdateMember(MemberDto dto) throws Exception;
}
