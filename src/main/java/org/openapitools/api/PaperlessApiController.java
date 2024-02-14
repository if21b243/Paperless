package org.openapitools.api;


import org.openapitools.services.dto.DocumentDTO;
import org.openapitools.services.dto.okresponse.GetDocument200Response;
import org.openapitools.services.dto.okresponse.GetDocuments200Response;

import org.openapitools.services.impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Generated;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import org.openapitools.jackson.nullable.JsonNullable;


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-22T12:32:07.613318Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.paperlessRestServer.base-path:}")
public class PaperlessApiController implements PaperlessApi {
    private final DocumentServiceImpl documentServiceImpl;

    private final NativeWebRequest request;

    @Autowired
    public PaperlessApiController(NativeWebRequest request, DocumentServiceImpl documentServiceImpl) {
        this.request = request;
        this.documentServiceImpl = documentServiceImpl;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

//    @Override
//    public ResponseEntity<Void> uploadDocument(String title, OffsetDateTime created, Integer documentType, List<Integer> tags, Integer correspondent, List<MultipartFile> document) {
//        DocumentsDocument response = documentServiceImpl.uploadDocument( title,  created,  documentType, tags, correspondent, document);
//
//
//        if (response != null) {
//
//
//            // return GetDocument200Response();
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//        return PaperlessApi.super.uploadDocument(title, created, documentType, tags, correspondent, document);
//    }

    @Override
    public ResponseEntity<GetDocument200Response> getDocument(Integer id, Integer page, Boolean fullPerms) {
        return ResponseEntity.ok(documentServiceImpl.getDocument(id, page, fullPerms));
    }


    @Override
    public ResponseEntity<Void> uploadDocument(String title, OffsetDateTime created, Integer documentType, List<Integer> tags, Integer correspondent, List<MultipartFile> document) {
        try {

            String name = document.get(0).getOriginalFilename();
            DocumentDTO documentDTO = new DocumentDTO();
            documentDTO.setTitle(JsonNullable.of(title == null ? name : title));
            documentDTO.setOriginalFileName(JsonNullable.of(name));
            documentDTO.setCreated(created);
            documentDTO.setDocumentType(JsonNullable.of(documentType));
            documentDTO.setTags(JsonNullable.of(tags));
            documentDTO.setCorrespondent(JsonNullable.of(correspondent));


            documentServiceImpl.uploadDocument(documentDTO, document);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }


    @Override
    public ResponseEntity<GetDocuments200Response> getDocuments(Integer page, Integer pageSize, String query, String ordering, List<Integer> tagsIdAll, Integer documentTypeId, Integer storagePathIdIn, Integer correspondentId, Boolean truncateContent) {
        return documentServiceImpl.getDocuments(page, pageSize, query, ordering, tagsIdAll, documentTypeId, storagePathIdIn, correspondentId, truncateContent);
    }



}
