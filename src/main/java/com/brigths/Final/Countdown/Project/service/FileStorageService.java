package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.FileDB;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileStorageService {

    public void init();

    public FileDB save(MultipartFile file) throws IOException;

    public Resource load(String filename);

    public void deleteAll();

    public Stream<Path> loadAll();

    FileDB getFile(String id);

    Stream<FileDB> getAllFiles();
}
