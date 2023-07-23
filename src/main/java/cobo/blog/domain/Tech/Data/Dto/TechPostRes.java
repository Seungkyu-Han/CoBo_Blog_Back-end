package cobo.blog.domain.Tech.Data.Dto;

import cobo.blog.global.Data.Entity.TechPostEntity;
import cobo.blog.global.Data.Entity.TechPostSkillTagMappingEntity;
import cobo.blog.global.Util.DateConversion;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TechPostRes {

    private UserInTechPostRes user;
    @ApiModelProperty(
            value = "TechPost ID(TechPost 불러오기에 사용하기 위함)",
            example = "1"
    )
    private Integer id;
    @ApiModelProperty(
            value = "TechPost 제목",
            example = "성능테스트 결과와 개선할 점"
    )
    private String title;
    @ApiModelProperty(
            value = "TechPost 작성일자",
            example = "20230723"
    )
    private String createdAt;
    @ApiModelProperty(
            value = "TechPost 사용된 SkillTag 이름들",
            example = "SpringBoot"
    )
    private List<String> skillTag;
    @ApiModelProperty(
            value = "TechPost 내용 앞부분",
            example = "성능테스트를 진행한 결과 응답 속도가 느린 문제가 있었습니다."
    )
    private String content;

    public TechPostRes(TechPostEntity techPostEntity) {
        this.user = new UserInTechPostRes(techPostEntity.getUser());
        this.id = techPostEntity.getId();
        this.title = techPostEntity.getTitle();
        this.createdAt = DateConversion.DateToString(techPostEntity.getCreatedAt());
        this.content = techPostEntity.getContent();
        this.skillTag = new ArrayList<>();
        for(TechPostSkillTagMappingEntity techPostSkillTagMappingEntity : techPostEntity.getTechPostSkillTagMappings())
            this.skillTag.add(techPostSkillTagMappingEntity.getSkillTag().getName());
    }
}
