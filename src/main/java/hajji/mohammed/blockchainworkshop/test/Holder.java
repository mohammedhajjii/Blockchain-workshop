package hajji.mohammed.blockchainworkshop.test;

import lombok.Setter;

@Setter
public class Holder implements View1, View2{

    private Integer integer = 100208;
    private Double aDouble = 788.86;




    @Override
    public Double getDouble() {
        return aDouble;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }
}
