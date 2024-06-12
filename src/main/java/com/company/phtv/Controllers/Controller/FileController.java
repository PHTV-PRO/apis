package com.company.phtv.Controllers.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/file")
public class FileController {
    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        // Tạo Resource từ đường dẫn image
        Resource imageResource = new ClassPathResource("Uploads/Images/" + imageName);

        // Kiểm tra xem image có tồn tại hay không
        if (!imageResource.exists()) {
            return ResponseEntity.notFound().build();
        }

        // Trả về image
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // Set content type
                .body(imageResource);
    }
}
