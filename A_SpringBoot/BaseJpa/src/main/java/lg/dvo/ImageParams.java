package lg.dvo;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class ImageParams {

    @NotBlank
    private String imageName;

    @NotBlank
    private  String geo;

}
