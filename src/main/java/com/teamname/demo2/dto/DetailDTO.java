/***********************************************
 * 클래스명 : DetailDTO
 * 기능 : 상세보기(및 수정)에서 사용하는 DTO
 * 작성자 : 김예령
 * 작성일 : 2025-03-26
 * 수정 : 2025-03-26
 * ***********************************************/
package com.teamname.demo2.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailDTO {
    private Integer id;                 //일련번호
    private String subject;             //제목
    private String content;             //내용
    private String author;              //작성자
    private LocalDateTime regDate;      //등록일자
    private LocalDateTime modDate;      //수정일자
}
