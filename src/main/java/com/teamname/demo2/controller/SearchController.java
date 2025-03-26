/***********************************************
 * 클래스명 : SearchController
 * 기능 :
 * 작성자 : 김예령
 * 작성일 : 2025-03-26
 * 수정 : 2025-03-26
 * ***********************************************/
package com.teamname.demo2.controller;

import com.teamname.demo2.dto.CreateDTO;
import com.teamname.demo2.dto.DetailDTO;
import com.teamname.demo2.dto.ListDTO;
import com.teamname.demo2.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.teamname.demo2.util.PaginationUtil.Pagination;

@Controller
//@RestController /*요청명령 많음.. 6가지??*/
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    /*목록*/
    @GetMapping(value = {"/","/list"}) /*메소드명과 연관*/
    public String listView(@PageableDefault(page=1) Pageable pageable,
                           @RequestParam(value = "type", defaultValue = "") String type,
                           @RequestParam(value = "keyword", defaultValue = "") String keyword,
                           Model model){

        Page<ListDTO> listDTOS = searchService.list(pageable, type, keyword);
        Map<String, Integer> pageInfo = Pagination(listDTOS);
        model.addAttribute("list",listDTOS);
        model.addAttribute("keyword",keyword);
        model.addAttribute("type",type);
        model.addAllAttributes(pageInfo);
        return "search/list";                      /*String과 연관*/
    }

    /*삽입*/
    @GetMapping("/create")
    public String createView(){
        return "search/create";
    }
    @PostMapping("/create")
    public String createProc(CreateDTO createDTO){
        System.out.println("등록 컨트롤러. : "+createDTO);
        searchService.create(createDTO);
        return "redirect:/list";
    }

    /*삭제*/
    @GetMapping("/delete")
    public String deleteProc(Integer id){
        searchService.delete(id);
        return "redirect:/list";
    }

    /*상세*/
    @GetMapping("/detail")
    public String detailProc(Integer id, Model model){
        DetailDTO detailDTO = searchService.detail(id);
        model.addAttribute("data",detailDTO);
        return "search/detail";
    }

    /*수정*/
    @GetMapping("/modify")
    public String modifyView(Integer id, Model model){
        DetailDTO detailDTO = searchService.detail(id);
        model.addAttribute("data",detailDTO);
        return "search/modify";
    }
    @PostMapping("/modify")
    public String modifyProc(DetailDTO detailDTO){
        searchService.modify(detailDTO);
        return "redirect:/";
    }
}
