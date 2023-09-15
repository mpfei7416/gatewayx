package com.lmpdyy.gatewayx.common.config;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName Rule
 * @description: 规则模型
 * @author: nxlea
 * @create: 2023-09-14 17:49
 */
public class Rule implements Comparable<Rule>, Serializable {

    private static final long serialVersionUID = -3996647830108696484L;

    // 全局唯一id
    private String id;

    // 规则名称
    private String name;

    //规则的序列化协议
    private String protocol;

    // 规则排序， 后期一个路径绑定多个规则， 但是最后只能一个规则， 根据该属性来判断优先级决定执行哪个
    private Integer order;

    private Set<FilterConfig> filterConfigs = new HashSet<>();

    public Rule() {
        super();
    }

    public Rule(String id, String name, String protocol, Integer order, Set<FilterConfig> filterConfig) {
        this.id = id;
        this.name = name;
        this.protocol = protocol;
        this.order = order;
        this.filterConfigs = filterConfig;
    }

    /**
     * <B>方法名称：</B>addFilterConfig<BR>
     * <B>概要说明：</B>向规则里面添加指定的过滤器<BR>
     */
    public boolean addFilterConfig(Rule.FilterConfig filterConfig) {
        return filterConfigs.add(filterConfig);
    }


    /**
     *  通过一个指定的filterId 获取 getFilterConfig信息
     */
    public Rule.FilterConfig getFilterConfig(String id) {
        for (FilterConfig filterConfig : filterConfigs) {
            if (filterConfig.getId().equals(id)) {
                return filterConfig;
            }
        }
        return null;
    }

    /**
     * 根据传入的filterId 判断当前Rule中是否存在
     */
    public boolean hashId(String id){
        for (FilterConfig filterConfig : filterConfigs) {
            if (filterConfig.getId().equals(id)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }


    @Override
    public int compareTo(Rule o) {
        int compare = Integer.compare(getOrder(), o.getOrder());
        if (compare == 0) {
            return getId().compareTo(o.getId());
        }
        return compare;
    }


    /**
     * 过滤器的配置类
     */
    public static class FilterConfig{
        private String id;

        private String config;

        public FilterConfig(String id, String config) {
            this.id = id;
            this.config = config;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getConfig() {
            return config;
        }

        public void setConfig(String config) {
            this.config = config;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FilterConfig that = (FilterConfig) o;
            return Objects.equals(id, that.id) && Objects.equals(config, that.config);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, config);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Set<FilterConfig> getFilterConfigs() {
        return filterConfigs;
    }

    public void setFilterConfigs(Set<FilterConfig> filterConfigs) {
        this.filterConfigs = filterConfigs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return Objects.equals(id, rule.id) && Objects.equals(name, rule.name) && Objects.equals(protocol, rule.protocol) && Objects.equals(order, rule.order) && Objects.equals(filterConfigs, rule.filterConfigs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, protocol, order, filterConfigs);
    }
}
