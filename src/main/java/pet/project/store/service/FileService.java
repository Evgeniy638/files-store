package pet.project.store.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    @Value("${path-upload}")
    private String pathUpload;

    public void save(MultipartFile multipartFile, String id) throws IOException {
        File folder = new File(pathUpload);

        if (!folder.exists()) {
            folder.mkdir();
        }

        File file = new File( pathUpload + "/" + id);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
    }
}
