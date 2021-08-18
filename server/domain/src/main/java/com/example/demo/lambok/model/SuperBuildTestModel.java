package com.example.demo.lambok.model;

import com.example.demo.lambok.model.base.BaseSuperBuildTestModel;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Setter(AccessLevel.PROTECTED)
public class SuperBuildTestModel extends BaseSuperBuildTestModel {

    public static void main(String[] args) {
        SuperBuildTestModel superBuildTestModel = new SuperBuildTestModel();
        superBuildTestModel.setName("zhangsan");
        System.out.println(superBuildTestModel);
    }

    public static SuperBuildTestModel buildByName(String name) {
        SuperBuildTestModel superBuildTestModel = new SuperBuildTestModel();
        superBuildTestModel.setName("zhangsan");
        return superBuildTestModel;
    }
}
