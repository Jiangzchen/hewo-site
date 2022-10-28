package org.hewo.core.controller;

import org.hewo.core.exception.BusinessException;
import org.hewo.core.model.entity.R;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.core.handle.Render;

public class AbstractController implements Render {

    @Override
    public void render(Object obj, Context ctx) throws Throwable {
        if (obj == null) {
            return;
        }

        if (obj instanceof String) {
            //普通字符串，直接输出
            ctx.output((String) obj);
        } else if (obj instanceof ModelAndView) {
            //视图模型，直接渲染
            ctx.render(obj);
        } else {
            if (obj instanceof BusinessException){
                BusinessException businessException = (BusinessException) obj;
                obj = R.error(100,businessException.getMessage());
            }
            ctx.render(obj);
        }
    }
}
