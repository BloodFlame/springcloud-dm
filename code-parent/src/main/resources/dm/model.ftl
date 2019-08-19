package cn.${package}.pojo;
import java.io.Serializable;
import java.util.Date;
/***
*   ${table.comment}
*/
public class ${table.className} implements Serializable {
    <#list table.cloumns as cloumn>
    //${cloumn.comment}
    private ${cloumn.javaType} ${cloumn.fieldName};
    </#list>
    //get set 方法
<#list table.cloumns as cloumn>
    public void set${cloumn.upperCasecloumnName} (${cloumn.javaType}  ${cloumn.fieldName}){
        this.${cloumn.fieldName}=${cloumn.fieldName};
    }
    public  ${cloumn.javaType} get${cloumn.upperCasecloumnName}(){
        return this.${cloumn.fieldName};
    }
</#list>
}
