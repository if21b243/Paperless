package org.openapitools.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-01T09:38:36.384080200+01:00[Europe/Vienna]")
@Controller
@RequestMapping("${openapi.mockServer.base-path:}")
public class ApiController implements Api {

    private final NativeWebRequest request;

    @Autowired
    public ApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
