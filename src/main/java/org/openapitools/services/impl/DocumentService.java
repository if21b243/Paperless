package org.openapitools.services.impl;

import org.openapitools.services.dto.DocumentDTO;
import org.openapitools.services.dto.okresponse.GetDocument200Response;
import org.openapitools.services.dto.okresponse.GetDocuments200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.List;

public interface DocumentService {
    GetDocument200Response getDocument(Integer id, Integer page, Boolean fullPerms);

    void uploadDocument(DocumentDTO documentDTO, List<MultipartFile> document);

    ResponseEntity<GetDocuments200Response> getDocuments(Integer page, Integer pageSize, String query, String ordering, List<Integer> tagsIdAll, Integer documentTypeId, Integer storagePathIdIn, Integer correspondentId, Boolean truncateContent);
}
