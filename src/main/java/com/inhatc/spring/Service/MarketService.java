package com.inhatc.spring.Service;

import com.inhatc.spring.DTO.MemberDto;
import com.inhatc.spring.DTO.ProductDto;
import com.inhatc.spring.Mapper.MarketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class MarketService {
    @Autowired
    MarketMapper marketMapper;

    @Value("${upload.path}")
    String rootPath;
    @Value("${upload.url.path}")
    String urlPath;

    public int processAddMember(MemberDto dto) throws Exception {
        return marketMapper.processAddMember(dto);
    }

    public MemberDto processLoginMember(MemberDto dto) throws Exception{
        return marketMapper.processLoginMember(dto);
    }

    public MemberDto processMemberInfo(MemberDto dto) throws Exception{
        return marketMapper.processMemberInfo(dto);
    }

    public int processUpdateMember(MemberDto dto) throws Exception{
        return marketMapper.processUpdateMember(dto);
    }

    // ProductDto dto
    public int processAddProduct(ProductDto dto) throws Exception {
        return marketMapper.processAddProduct(dto);
    }

    public void saveImage(ProductDto dto, MultipartFile productImage) throws Exception {
        try {
            File file = new File(rootPath + "/" + productImage.getOriginalFilename());
            productImage.transferTo(file);
            dto.setFileName(urlPath + file.getName());
        } catch (Exception e){
        }
    }

    public List<ProductDto> listProducts(ProductDto dto) throws Exception{
        return marketMapper.listProducts(dto);
    }

    public ProductDto getProduct(ProductDto dto) throws Exception{
        return marketMapper.getProduct(dto);
    }

    public int processUpdateProduct(ProductDto dto) throws Exception{
        return marketMapper.processUpdateProduct(dto);
    }
}
