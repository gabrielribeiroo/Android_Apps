package com.example.ado_1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProdListar extends AppCompatActivity {
    private TextView txtProdutoNome4;
    private TextView txtProdutoPrecoVenda8;
    private TextView txtProdutoLucro;
    private TextView txtProdutoPrecoCompra4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_listar);
        this.txtProdutoNome4 = (TextView) findViewById(R.id.txtProdutoNome4);
        this.txtProdutoPrecoCompra4 = (TextView) findViewById(R.id.txtProdutoPrecoCompra4);
        this.txtProdutoPrecoVenda8 = (TextView) findViewById(R.id.txtProdutoPrecoVenda8);
        this.txtProdutoLucro = (TextView) findViewById(R.id.txtProdutoLucro);
        LimparCampos();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nomeProd = bundle.getString("nomeProd");
        Double valorCompra = bundle.getDouble("valorCompra");
        String valorCompraString = valorCompra.toString();
        Double valorVenda = bundle.getDouble("valorVenda");
        String valorVendaString = valorVenda.toString();
        Double lucro = bundle.getDouble("lucro");
        String lucroString = lucro.toString();
        setTextCampos(nomeProd,valorCompraString,valorVendaString,lucroString);
    }
    public void setTextCampos(String nome, String valorCompra, String valorVenda, String lucro){
        this.txtProdutoNome4.setText(nome);
        this.txtProdutoPrecoCompra4.setText(valorCompra);
        this.txtProdutoPrecoVenda8.setText(valorVenda);
        this.txtProdutoLucro.setText(lucro);
    }

    public void LimparCampos(){
        this.txtProdutoNome4.setText("");
        this.txtProdutoPrecoCompra4.setText("");
        this.txtProdutoPrecoVenda8.setText("");
        this.txtProdutoLucro.setText("");
    }


}
