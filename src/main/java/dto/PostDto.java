package dto;

import lombok.Data;

@Data //data 형식에 자주 쓰는 모든 메소드 get,set,toString 다 포함하는 annotation
public class PostDto {
    private String title;
    private String content;

}
