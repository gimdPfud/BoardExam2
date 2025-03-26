/***********************************************
 * 클래스명 : SearchService
 * 기능 : 서비스입니다.
 * 작성자 : 김예령
 * 작성일 : 2025-03-26
 * 수정 : 2025-03-26
 * ***********************************************/
package com.teamname.demo2.service;

import com.teamname.demo2.dto.CreateDTO;
import com.teamname.demo2.dto.DetailDTO;
import com.teamname.demo2.dto.ListDTO;
import com.teamname.demo2.entity.SearchEntity;
import com.teamname.demo2.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//주석 요렁
//설명
//todo : 앞으로 작업할 지시내용 적기
//FixMe : 수정할 부분에 지시내용 적기

@Service
@Transactional
@RequiredArgsConstructor
public class SearchService {
    private final ModelMapper modelMapper;
    private final SearchRepository searchRepository;
    //Controller 메소드의 ()안에 인수를 보고 작성

    /*목록*/
    public Page<ListDTO> list(Pageable pageable, String type, String keyword){
        int currentPage = pageable.getPageNumber()-1;
        int limits = 10;
        Pageable temp = PageRequest.of(currentPage, limits, Sort.by(Sort.Direction.DESC,"id"));
        Page<SearchEntity> entities = searchRepository.findAll(temp);
        Page<ListDTO> listDTOS = entities.map(data -> modelMapper.map(data, ListDTO.class));
        return listDTOS;
    }

    /*삽입*/
    public void create(CreateDTO createDTO){
        try {
            SearchEntity entity = modelMapper.map(createDTO, SearchEntity.class);
            searchRepository.save(entity);
        } catch (Exception e) {
            System.out.println("등록 오류 발생.");
        }
    }

    /*삭제*/
    public void delete(Integer id){
        return;
    }

    /*상세보기*/
    public DetailDTO detail(Integer id){
        return null;
    }

    /*수정*/
    public void modify(DetailDTO detailDTO){
        return;
    }

}
