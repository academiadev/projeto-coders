package br.com.academiadev.projetocoders.reembolsocoders.common;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TimeProvider    {
    private static final long serialVersionUID = -3301695478208950415L;

    public Date getDataAtual() {
        return new Date();
    }

















}
