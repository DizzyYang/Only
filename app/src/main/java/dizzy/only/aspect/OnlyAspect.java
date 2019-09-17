package dizzy.only.aspect;

import android.view.View;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Dizzy
 * 2019/6/6 16:16
 * 简介：Only
 */
@Aspect
public class OnlyAspect {

    private static final long CLICK_DELAY_TIME = 1000L;
    private long lastClickTime;
    private int lastViewId;

    @Around("execution(* android.view.View.OnClickListener.onClick(..))")
    public void onClick(ProceedingJoinPoint joinPoint) {
        View view = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof View) {
                view = (View) arg;
                break;
            }
        }
        if (view == null) {
            return;
        }
        int viewId = view.getId();
        long currentTime = System.currentTimeMillis();
        if (!(viewId == lastViewId && currentTime - lastClickTime < CLICK_DELAY_TIME)) {
            try {
                joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            lastClickTime = currentTime;
            lastViewId = viewId;
        }
    }

}
