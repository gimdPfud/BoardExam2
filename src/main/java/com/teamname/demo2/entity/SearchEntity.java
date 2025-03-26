/***********************************************
 * 클래스명 : SearchEntity
 * 기능 :
 * 작성자 : 김예령
 * 작성일 : 2025-03-26
 * 수정 : 2025-03-26
 * ***********************************************/
package com.teamname.demo2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
* 테이블 조인 작업 시 반드시 @ToString은 사용하면 안된다.
* @ToString을 쓰면 재귀함수로 무한반복 > 오류. */
@Entity
@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "search")
@SequenceGenerator(
        /*자동숫자를 생성하고, 정보를 저장함.*/
        name = "search_seq",    //테이블+seq
        sequenceName = "search_seq",
        initialValue = 1,       //시작값
        allocationSize = 1      //크기
)
@EntityListeners(AuditingEntityListener.class)//Entity와 1:1로만 사용
public class SearchEntity {
    @Id                                                 //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY, //기본키의 사용방법
            generator = "search_seq")                   //Sequence : 순차처리(1,2,3 ..)
                                                        // 근데 서버를 껐다 킬때마다 시작하는 번호가 달라짐.
                                                        // 불규칙하게 숫자가 생성...
    @Column(name = "id", nullable = false)
    private Integer id;                 //번호

    @Column(name = "subject", nullable = false, length = 50)
    private String subject;             //제목

    @Column(name = "content", length = 200)
    private String content;             //내용

    @Column(name = "author", length = 20)
    private String author;              //작성자

    @CreatedDate
    @Column(name = "regDate", nullable = false, updatable = false)
    private LocalDateTime regDate;      //등록일자

    @LastModifiedDate
    @Column(name = "modDate", nullable = false)
    private LocalDateTime modDate;      //수정일자

    //생성자 getter setter tostring build 는 Lombok 어노테이션으로 대체
    //modelmapper사용 안하면 여기다 변환메소드 만들면 됨.
}
/*
* 1. 변수선언
* 2. column 지정
* 3. join 지정
* */
