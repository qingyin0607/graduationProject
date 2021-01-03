package com.graduationproject.schoolmapsystem.utils;
import java.io.Serializable;

public class Result implements Serializable {
    // 结果标记(true:执行成功 false:执行失败)
    private Boolean flag;
    // 消息状态码
    private Integer code;
    // 消息
    private String msg;
    // 返回数据
    private Object data;
    // 总条数
    private Long total;
    //一页显示条数
    private Long size;
    //总页数
    private Long page;


    private Result(Boolean flag, Integer code, String msg, Object data) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(Boolean flag, Integer code, String msg, Object data, long size, long total, long page) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.size =size;
        this.total=total;
        this.page=page;
    }



    /**
     * 响应成功(带返回数据)
     * @param data 返回数据
     * @return Result
     */
    public static com.graduationproject.schoolmapsystem.utils.Result success(Object data){
        return new com.graduationproject.schoolmapsystem.utils.Result(true,0,"响应成功",data);
    }

    /**
     * 响应成功
     * @return Result
     */
    public static com.graduationproject.schoolmapsystem.utils.Result success(){
        return new com.graduationproject.schoolmapsystem.utils.Result(true,0,"响应成功",null);
    }

    public static com.graduationproject.schoolmapsystem.utils.Result success(Object data, long size, long total, long page){
        return new com.graduationproject.schoolmapsystem.utils.Result(true,0,"响应成功",data,size,total,page);
    }



    /**
     * 响应错误(不带状态码,带消息)
     * @return Result
     */
    public static com.graduationproject.schoolmapsystem.utils.Result error(String msg){
        return new com.graduationproject.schoolmapsystem.utils.Result(false,1,msg,null);
    }

    /**
     * 响应错误(带错误码,消息提醒)
     * @return Result
     */
    public static com.graduationproject.schoolmapsystem.utils.Result errorMsg(Integer code, String msg){
        return new com.graduationproject.schoolmapsystem.utils.Result(false,code,msg,null);
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }


}


