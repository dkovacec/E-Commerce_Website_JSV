package com.brigths.Final.Countdown.Project.repository;

import com.brigths.Final.Countdown.Project.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {


}
