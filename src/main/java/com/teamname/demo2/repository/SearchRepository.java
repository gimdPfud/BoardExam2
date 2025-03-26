/***********************************************
 * 클래스명 : SearchRepository
 * 기능 :
 * 작성자 : 김예령
 * 작성일 : 2025-03-26
 * 수정 : 2025-03-26
 * ***********************************************/
package com.teamname.demo2.repository;

import com.teamname.demo2.entity.SearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<SearchEntity, Integer> {
}
