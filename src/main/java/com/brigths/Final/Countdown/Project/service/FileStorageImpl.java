package com.brigths.Final.Countdown.Project.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileStorageImpl implements FileStorageService{


    private final Path root = Paths.get("uploads");

    @Override
    public void init() {

        try{
        Files.createDirectories(root);
        }catch (Exception e){
            throw new RuntimeException("Could not initialize upload folder");
            }
        }

    @Override
    public void save(MultipartFile file) {

        try{
        Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        }catch(Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file with that name already exists");
            }
        }

    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
