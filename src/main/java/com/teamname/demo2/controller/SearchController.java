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
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RestController /*요청명령 많음.. 6가지??*/
@RequestMapping
@RequiredArgsConstructor
public class SearchController {
    /*목록*/
    @GetMapping(value = {"/","/list"}) /*메소드명과 연관*/
    public String listView(@PageableDefault(page = 1) Pageable pageable,
                           @RequestParam(value = "type", defaultValue = "") String type,
                           @RequestParam(value = "keyword", defaultValue = "") String keyword,
                           Model model){
        return "search/list";                      /*String과 연관*/
    }

    /*삽입*/
    @GetMapping("/create")
    public String createView(){
        return "search/create";
    }
    @PostMapping("/create")
    public String createProc(CreateDTO createDTO){
        return "redirect:/list";
    }

    /*삭제*/
    @GetMapping("/delete")
    public String deleteProc(Integer id){
        return "redirect:/list";
    }

    /*상세*/
    @GetMapping("/detail")
    public String detailProc(Integer id, Model model){
        return "search/detail";
    }

    /*수정*/
    @GetMapping("/modify")
    public String modifyView(Integer id, Model model){
        return "search/modify";
    }
    @PostMapping("/modify")
    public String modifyProc(DetailDTO detailDTO){
        return "redirect:/";
    }
}
