package com.exanple.demo.design.build.annotations;

public class Simple {
    private String zs;
    private String ll;

    Simple(final String zs, final String ll) {
        this.zs = zs;
        this.ll = ll;
    }

    public static Simple.SimpleBuilder builder() {
        return new Simple.SimpleBuilder();
    }

    public String toString() {
        String var10000 = super.toString();
        return "Simple(super=" + var10000 + ", zs=" + this.zs + ", ll=" + this.ll + ")";
    }

    public static class SimpleBuilder {
        private String zs;
        private String ll;

        SimpleBuilder() {
        }

        public Simple.SimpleBuilder zs(final String zs) {
            this.zs = zs;
            return this;
        }

        public Simple.SimpleBuilder ll(final String ll) {
            this.ll = ll;
            return this;
        }

        public Simple build() {
            return new Simple(this.zs, this.ll);
        }

        public String toString() {
            return "Simple.SimpleBuilder(zs=" + this.zs + ", ll=" + this.ll + ")";
        }
    }
}
