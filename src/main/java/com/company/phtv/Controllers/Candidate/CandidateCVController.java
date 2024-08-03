package com.company.phtv.Controllers.Candidate;

import com.company.phtv.Controllers.BaseController;
import com.company.phtv.Models.DTO.CVDTO;
import com.company.phtv.Models.Request.RequestCV;
import com.company.phtv.Models.Request.RequestDataCreateCV;
import com.company.phtv.Services.CVService;
import com.company.phtv.Utils.Convert;
import com.company.phtv.Utils.Html;
import com.company.phtv.Utils.HttpException;
import com.company.phtv.Utils.Variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/candidate/cv")
public class CandidateCVController {
    @Autowired
    CVService _cvService;
    BaseController<CVDTO> _baseController = new BaseController<CVDTO>();
    BaseController<List<CVDTO>> _baseControllers = new BaseController<List<CVDTO>>();
    BaseController<String> _baseControllerString = new BaseController<String>();

    @GetMapping("/account")
    public ResponseEntity<?> getByAccount(@RequestParam int size, @RequestParam int page) {
        try {
            return _baseControllers.success(_cvService.getByAccount(size, page));
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> post(@RequestParam MultipartFile file, @RequestParam String name) {
        try {
            return _baseController.success(_cvService.create(new RequestCV(file, name)));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam int id) {
        try {
            return _baseController.success(_cvService.delete(id));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable int id, @RequestParam String name) {
        try {
            return _baseController.success(_cvService.delete(id));
        } catch (HttpException e) {
            return _baseControllers.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseControllers.error(null, 500, e.getMessage());
        }
    }

    @PostMapping("/generate_pdf")
    public ResponseEntity<?> generatePdf(@RequestBody RequestDataCreateCV requestDataCreateCV) {
        try {
            String htmlContent = Html.GET_HTML_CV(requestDataCreateCV);
            byte[] pdfBytes = Convert.convertHtmlToPdf(htmlContent);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDisposition(ContentDisposition.attachment().filename("document.pdf").build());

            MultipartFile multipartFile = new MockMultipartFile(
                    "cv",
                    "cv.pdf",
                    "pdf",
                    pdfBytes);

            _cvService.create(new RequestCV(multipartFile, requestDataCreateCV.getName_cv()));
            return _baseControllerString.success("Success");
        } catch (HttpException e) {
            return _baseController.error(null, e.StatusCode, e.message);
        } catch (Exception e) {
            return _baseController.error(null, 500, e.getMessage());
        }
    }

}
