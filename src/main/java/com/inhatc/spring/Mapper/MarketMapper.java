package com.inhatc.spring.Mapper;

import com.inhatc.spring.DTO.MemberDto;
import com.inhatc.spring.DTO.ProductDto;

import java.util.List;

public interface MarketMapper {

    int processAddMember(MemberDto dto) throws Exception;
    MemberDto processLoginMember(MemberDto dto) throws Exception;
    MemberDto processMemberInfo(MemberDto dto) throws Exception;
    int processUpdateMember(MemberDto dto) throws Exception;
    int processAddProduct(ProductDto dto) throws Exception;
    List<ProductDto> listProducts(ProductDto dto) throws Exception;
}
