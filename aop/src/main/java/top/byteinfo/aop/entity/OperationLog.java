//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.byteinfo.aop.entity;

public class OperationLog {
    private Integer id;
    private String ipAddress;

    public static OperationLogBuilder builder() {
        return new OperationLogBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }



    public String toString() {
        return "OperationLog(id=" + this.getId() + ", ipAddress=" + this.getIpAddress() + ")";
    }

    public OperationLog(final Integer id, final String ipAddress) {
        this.id = id;
        this.ipAddress = ipAddress;
    }

    public OperationLog() {
    }

    public static class OperationLogBuilder {
        private Integer id;
        private String ipAddress;

        OperationLogBuilder() {
        }

        public OperationLogBuilder id(final Integer id) {
            this.id = id;
            return this;
        }

        public OperationLogBuilder ipAddress(final String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public OperationLog build() {
            return new OperationLog(this.id, this.ipAddress);
        }

        public String toString() {
            return "OperationLog.OperationLogBuilder(id=" + this.id + ", ipAddress=" + this.ipAddress + ")";
        }
    }
}
