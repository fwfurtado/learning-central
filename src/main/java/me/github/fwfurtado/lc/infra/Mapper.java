package me.github.fwfurtado.lc.infra;

public interface Mapper<S, T> {
    T map(S input);
}
