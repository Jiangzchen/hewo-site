package org.hewo.core.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Test {

    private List<List<String>> structureData;
}
