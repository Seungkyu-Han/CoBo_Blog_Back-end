package cobo.blog.domain.Tech;

import cobo.blog.domain.Tech.Data.Dto.TechPostRes;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tech")
@AllArgsConstructor
@Api(tags = {"03. Tech 화면에 사용하는 API"})
public class TechController {

    private final TechServiceImpl techService;

    @GetMapping("/posts")
    @ApiOperation(
            value = "Tech Post 의 정보를 List 응답",
            notes = "페이지 1부터 시작합니다, 주의 부탁드립니다.",
            response = TechPostRes.class
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지 번호", example = "1", required = true),
            @ApiImplicitParam(name = "size", value = "페이지의 사이즈", example = "10", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "응답 성공")
    })
    public ResponseEntity<List<TechPostRes>> getPosts(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size){
        return techService.getPosts(page, size);
    }
}