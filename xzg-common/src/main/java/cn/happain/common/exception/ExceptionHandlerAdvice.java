package cn.happain.common.exception;

import cn.happain.common.dto.Response;
import cn.happain.common.exception.exception.PermissionException;
import cn.happain.common.utils.GlobalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @创建人 happain
 * @创建时间 2023/1/25
 * @描述 统一异常处理类
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {


    @Autowired
    private GlobalUtil globalUtil;

    /**字段验证异常*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response validExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e)  {
        globalUtil.exceptionLog(req);
        StringBuffer stringBuffer = new StringBuffer();
        List<FieldError> fieldErrors = e.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            stringBuffer.append(fieldError.getDefaultMessage()+"\n");
        }
        return Response.failDefault(stringBuffer.toString());
    }

    /**权限不足异常*/
    @ExceptionHandler(PermissionException.class)
    public Response permissionExceptionHandler(HttpServletRequest req, PermissionException e) {
        globalUtil.exceptionLog(req);
        return Response.failPermission();
    }

    /** 默认异常*/
    @ExceptionHandler(Exception.class)
    public Response exceptionHandler(HttpServletRequest req, Exception e) {
        globalUtil.exceptionLog(req);
        return Response.failDefault(e.getMessage());
    }
}
