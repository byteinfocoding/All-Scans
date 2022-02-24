package top.byteinfo.swagger2.configs;

/**
 * Swagger自定义配置
 * Created by macro on 2020/7/16.
 */
////@Builder
//
//@Data
//@EqualsAndHashCode(callSuper = false)
//public class SwaggerProperties {
//    /**
//     * API文档生成基础路径
//     */
//    private String apiBasePackage;
//    /**
//     * 是否要启用登录认证
//     */
//    private boolean enableSecurity;
//    /**
//     * 文档标题
//     */
//    private String title;
//    /**
//     * 文档描述
//     */
//    private String description;
//    /**
//     * 文档版本
//     */
//    private String version;
//    /**
//     * 文档联系人姓名
//     */
//    private String contactName;
//    /**
//     * 文档联系人网址
//     */
//    private String contactUrl;
//    /**
//     * 文档联系人邮箱
//     */
//    private String contactEmail;
//
//
//    public static SwaggerProperties.SwaggerPropertiesBuilder builder() {
//        return new SwaggerProperties.SwaggerPropertiesBuilder();
//    }
//
//    SwaggerProperties(final String apiBasePackage, final boolean enableSecurity, final String title, final String description, final String version, final String contactName, final String contactUrl, final String contactEmail) {
//        this.apiBasePackage = apiBasePackage;
//        this.enableSecurity = enableSecurity;
//        this.title = title;
//        this.description = description;
//        this.version = version;
//        this.contactName = contactName;
//        this.contactUrl = contactUrl;
//        this.contactEmail = contactEmail;
//    }
//    public static class SwaggerPropertiesBuilder {
//        private String apiBasePackage;
//        private boolean enableSecurity;
//        private String title;
//        private String description;
//        private String version;
//        private String contactName;
//        private String contactUrl;
//        private String contactEmail;
//
//        SwaggerPropertiesBuilder() {
//        }
//
//        public SwaggerProperties.SwaggerPropertiesBuilder apiBasePackage(final String apiBasePackage) {
//            this.apiBasePackage = apiBasePackage;
//            return this;
//        }
//
//        public SwaggerProperties.SwaggerPropertiesBuilder enableSecurity(final boolean enableSecurity) {
//            this.enableSecurity = enableSecurity;
//            return this;
//        }
//
//        public SwaggerProperties.SwaggerPropertiesBuilder title(final String title) {
//            this.title = title;
//            return this;
//        }
//
//        public SwaggerProperties.SwaggerPropertiesBuilder description(final String description) {
//            this.description = description;
//            return this;
//        }
//
//        public SwaggerProperties.SwaggerPropertiesBuilder version(final String version) {
//            this.version = version;
//            return this;
//        }
//
//        public SwaggerProperties.SwaggerPropertiesBuilder contactName(final String contactName) {
//            this.contactName = contactName;
//            return this;
//        }
//
//        public SwaggerProperties.SwaggerPropertiesBuilder contactUrl(final String contactUrl) {
//            this.contactUrl = contactUrl;
//            return this;
//        }
//
//        public SwaggerProperties.SwaggerPropertiesBuilder contactEmail(final String contactEmail) {
//            this.contactEmail = contactEmail;
//            return this;
//        }
//
//        public SwaggerProperties build() {
//            return new SwaggerProperties(this.apiBasePackage, this.enableSecurity, this.title, this.description, this.version, this.contactName, this.contactUrl, this.contactEmail);
//        }
//
//        public String toString() {
//            return "SwaggerProperties.SwaggerPropertiesBuilder(apiBasePackage=" + this.apiBasePackage + ", enableSecurity=" + this.enableSecurity + ", title=" + this.title + ", description=" + this.description + ", version=" + this.version + ", contactName=" + this.contactName + ", contactUrl=" + this.contactUrl + ", contactEmail=" + this.contactEmail + ")";
//        }
//    }
////    public static class Builder extends SwaggerProperties {
////
////        public Builder(SwaggerProperties m) {
////            super(m);
////        }
//////
//////        public JsonMapper.Builder enable(JsonReadFeature... features) {
//////            JsonReadFeature[] var2 = features;
//////            int var3 = features.length;
//////
//////            for(int var4 = 0; var4 < var3; ++var4) {
//////                JsonReadFeature f = var2[var4];
//////                ((JsonMapper)this._mapper).enable(new JsonParser.Feature[]{f.mappedFeature()});
//////            }
//////
//////            return this;
//////        }
//////
//////        public JsonMapper.Builder disable(JsonReadFeature... features) {
//////            JsonReadFeature[] var2 = features;
//////            int var3 = features.length;
//////
//////            for(int var4 = 0; var4 < var3; ++var4) {
//////                JsonReadFeature f = var2[var4];
//////                ((JsonMapper)this._mapper).disable(new JsonParser.Feature[]{f.mappedFeature()});
//////            }
//////
//////            return this;
//////        }
//////
//////        public JsonMapper.Builder configure(JsonReadFeature f, boolean state) {
//////            if (state) {
//////                ((JsonMapper)this._mapper).enable(new JsonParser.Feature[]{f.mappedFeature()});
//////            } else {
//////                ((JsonMapper)this._mapper).disable(new JsonParser.Feature[]{f.mappedFeature()});
//////            }
//////
//////            return this;
//////        }
//////
//////        public JsonMapper.Builder enable(JsonWriteFeature... features) {
//////            JsonWriteFeature[] var2 = features;
//////            int var3 = features.length;
//////
//////            for(int var4 = 0; var4 < var3; ++var4) {
//////                JsonWriteFeature f = var2[var4];
//////                ((JsonMapper)this._mapper).enable(new com.fasterxml.jackson.core.JsonGenerator.Feature[]{f.mappedFeature()});
//////            }
//////
//////            return this;
//////        }
//////
//////        public JsonMapper.Builder disable(JsonWriteFeature... features) {
//////            JsonWriteFeature[] var2 = features;
//////            int var3 = features.length;
//////
//////            for(int var4 = 0; var4 < var3; ++var4) {
//////                JsonWriteFeature f = var2[var4];
//////                ((JsonMapper)this._mapper).disable(new com.fasterxml.jackson.core.JsonGenerator.Feature[]{f.mappedFeature()});
//////            }
//////
//////            return this;
//////        }
//////
//////        public JsonMapper.Builder configure(JsonWriteFeature f, boolean state) {
//////            if (state) {
//////                ((JsonMapper)this._mapper).enable(new com.fasterxml.jackson.core.JsonGenerator.Feature[]{f.mappedFeature()});
//////            } else {
//////                ((JsonMapper)this._mapper).disable(new com.fasterxml.jackson.core.JsonGenerator.Feature[]{f.mappedFeature()});
//////            }
//////
//////            return this;
//////        }
////    }
//}

public class SwaggerProperties {
    private String apiBasePackage;
    private boolean enableSecurity;
    private String title;
    private String description;
    private String version;
    private String contactName;
    private String contactUrl;
    private String contactEmail;

    SwaggerProperties(final String apiBasePackage, final boolean enableSecurity, final String title, final String description, final String version, final String contactName, final String contactUrl, final String contactEmail) {
        this.apiBasePackage = apiBasePackage;
        this.enableSecurity = enableSecurity;
        this.title = title;
        this.description = description;
        this.version = version;
        this.contactName = contactName;
        this.contactUrl = contactUrl;
        this.contactEmail = contactEmail;
    }


    public String getApiBasePackage() {
        return this.apiBasePackage;
    }

    public boolean isEnableSecurity() {
        return this.enableSecurity;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getVersion() {
        return this.version;
    }

    public String getContactName() {
        return this.contactName;
    }

    public String getContactUrl() {
        return this.contactUrl;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setApiBasePackage(final String apiBasePackage) {
        this.apiBasePackage = apiBasePackage;
    }

    public void setEnableSecurity(final boolean enableSecurity) {
        this.enableSecurity = enableSecurity;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public void setContactName(final String contactName) {
        this.contactName = contactName;
    }

    public void setContactUrl(final String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public void setContactEmail(final String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String toString() {
        return "SwaggerProperties(apiBasePackage=" + this.getApiBasePackage() + ", enableSecurity=" + this.isEnableSecurity() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", version=" + this.getVersion() + ", contactName=" + this.getContactName() + ", contactUrl=" + this.getContactUrl() + ", contactEmail=" + this.getContactEmail() + ")";
    }

    public static SwaggerProperties.SwaggerPropertiesBuilder builder() {
        return new SwaggerProperties.SwaggerPropertiesBuilder();
    }

    public static class SwaggerPropertiesBuilder {
        private String apiBasePackage;
        private boolean enableSecurity;
        private String title;
        private String description;
        private String version;
        private String contactName;
        private String contactUrl;
        private String contactEmail;

        SwaggerPropertiesBuilder() {
        }

        public SwaggerProperties.SwaggerPropertiesBuilder apiBasePackage(final String apiBasePackage) {
            this.apiBasePackage = apiBasePackage;
            return this;
        }

        public SwaggerProperties.SwaggerPropertiesBuilder enableSecurity(final boolean enableSecurity) {
            this.enableSecurity = enableSecurity;
            return this;
        }

        public SwaggerProperties.SwaggerPropertiesBuilder title(final String title) {
            this.title = title;
            return this;
        }

        public SwaggerProperties.SwaggerPropertiesBuilder description(final String description) {
            this.description = description;
            return this;
        }

        public SwaggerProperties.SwaggerPropertiesBuilder version(final String version) {
            this.version = version;
            return this;
        }

        public SwaggerProperties.SwaggerPropertiesBuilder contactName(final String contactName) {
            this.contactName = contactName;
            return this;
        }

        public SwaggerProperties.SwaggerPropertiesBuilder contactUrl(final String contactUrl) {
            this.contactUrl = contactUrl;
            return this;
        }

        public SwaggerProperties.SwaggerPropertiesBuilder contactEmail(final String contactEmail) {
            this.contactEmail = contactEmail;
            return this;
        }

        public SwaggerProperties build() {
            return new SwaggerProperties(this.apiBasePackage, this.enableSecurity, this.title, this.description, this.version, this.contactName, this.contactUrl, this.contactEmail);
        }

        public String toString() {
            return "SwaggerProperties.SwaggerPropertiesBuilder(apiBasePackage="
                    + this.apiBasePackage + ", enableSecurity="
                    + this.enableSecurity + ", title="
                    + this.title + ", description="
                    + this.description + ", version="
                    + this.version + ", contactName="
                    + this.contactName + ", contactUrl="
                    + this.contactUrl + ", contactEmail="
                    + this.contactEmail + ")";
        }
    }
}
