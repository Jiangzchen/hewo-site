package org.hewo.core.constant;

/**
 * 系统级静态变量
 */
public class SystemConstant {
    /**
     * 超级管理员ID
     */
    public static final long SUPER_ADMIN = 1;
    /**
     * 数据标识
     */
    public static final String DATA_ROWS = "rows";

    /**
     * 通用字典
     */
    public enum MacroType {

        /**
         * 类型
         */
        TYPE(0),

        /**
         * 参数
         */
        PARAM(1);

        private int value;

        MacroType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    /**
     * 通用变量，表示可用、禁用、显示、隐藏
     */
    public enum StatusType {

        /**
         * 禁用，隐藏
         */
        DISABLE(0),

        /**
         * 可用，显示
         */
        ENABLE(1),

        /**
         * 显示
         */
        SHOW(1),

        /**
         * 隐藏
         */
        HIDDEN(0);

        private int value;

        StatusType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

}