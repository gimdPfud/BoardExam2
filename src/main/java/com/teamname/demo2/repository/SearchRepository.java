/***********************************************
 * 클래스명 : SearchRepository
 * 기능 :
 * 작성자 : 김예령
 * 작성일 : 2025-03-26
 * 수정 : 2025-03-26
 * ***********************************************/
package com.teamname.demo2.repository;

import com.teamname.demo2.entity.SearchEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<SearchEntity, Integer> {

    /*제목*/
    @Query("select s from SearchEntity s where s.subject like concat('%', ?1, '%')")
    Page<SearchEntity> sub(String keyword, Pageable pageable);

    /*내용*/
    @Query("select s from SearchEntity s where s.content like concat('%', ?1, '%')")
    Page<SearchEntity> con(String keyword, Pageable pageable);

    /*작성자*/
    @Query("select s from SearchEntity s where s.author like concat('%', ?1, '%')")
    Page<SearchEntity> aut(String keyword, Pageable pageable);

    /*제목내용*/
    @Query("select s from SearchEntity s " +
            "where s.subject like %:keyword% " +
            "or s.content like %:keyword%")
    Page<SearchEntity> subcon(String keyword, Pageable pageable);

    /*제목내용작성자*/
    @Query("select s from SearchEntity s " +
            "where s.subject like %:keyword% " +
            "or s.content like %:keyword% " +
            "or s.author like %:keyword%")
    Page<SearchEntity> searchAll(String keyword, Pageable pageable);


}
