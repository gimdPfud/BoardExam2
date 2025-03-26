/***********************************************
 * 클래스명 : CreateDTO
 * 기능 : 등록에 사용하는 DTO
 * 작성자 : 김예령
 * 작성일 : 2025-03-26
 * 수정 : 2025-03-26
 * ***********************************************/
package com.teamname.demo2.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDTO {
    private String subject;             //제목
    private String content;             //내용
    private String author;              //작성자
}
