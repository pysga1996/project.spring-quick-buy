package com.omega.model.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "manufacturer", namespace = "http://www.omega.buy")
public class ManufacturerDTO {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    @JsonView(Views.Public.class)
    @NotNull(message = "{validation.manufacturer.id}", groups = {Groups.Update.class})
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull(message = "{validation.manufacturer.code}", groups = {Groups.Update.class})
    private String code;

    @JsonView(Views.Public.class)
    @NotBlank(message = "{validation.manufacturer.name}",
            groups = {Groups.Create.class, Groups.Update.class})
    private String name;

    @JsonView(Views.Public.class)
    @Size(message = "{validation.manufacturer.description}", min = 20, max = 100,
            groups = {Groups.Create.class, Groups.Update.class})
    private String description;

    @JacksonXmlElementWrapper(localName = "products")
    @JacksonXmlProperty(localName = "product", namespace = "http://www.omega.buy")
    @JsonView(Views.Internal.class)
    private Collection<ProductDTO> products;

    public interface Groups {
        interface Create {
        }

        interface Update {
        }
    }

    public interface Views {
        interface Public {
        }

        interface Internal extends Public, ProductDTO.Views.Public {
        }
    }

}
