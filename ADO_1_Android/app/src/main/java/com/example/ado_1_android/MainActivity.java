package com.example.ado_1_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.CleartextNetworkViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button BtnAdicionar;
    private Button btnPesquisar;
    private EditText txtNome;
    private EditText txtPrecoCusto;
    private EditText txtPrecoVenda;
    private EditText txtPesquisarProd;
    private Produto produto;
    private ArrayList<Produto> listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtPrecoCusto = (EditText) findViewById(R.id.txtPrecoCusto);
        txtPrecoVenda = (EditText) findViewById(R.id.txtPrecoVenda);
        txtPesquisarProd = (EditText) findViewById(R.id.txtPesquisarProd);
        BtnAdicionar = (Button) findViewById(R.id.BtnAdicionar);
        btnPesquisar = (Button) findViewById(R.id.btnPesquisar);
        this.listaProdutos = new ArrayList<Produto>();
        this.onClickAdicionarProduto();
        this.btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto result = pesquisarProd();
                if(result != null){
                Intent intent = new Intent(MainActivity.this, ProdListar.class);
                Bundle bundle = new Bundle();
                bundle.putString("nomeProd", result.getNomeProduto());
                bundle.putDouble("valorCompra",result.getPrecoCompra());
                bundle.putDouble("valorVenda", result.getPrecoVenda());
                bundle.putDouble("lucro",result.getLucro());
                intent.putExtras(bundle);
                startActivity(intent);

                }else{
                    LimparCampos();
                    Toast.makeText(MainActivity.this, "Não existe esse produto Cadastrado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public Produto pesquisarProd(){
        String nomeProd = this.txtPesquisarProd.getText().toString();
        if(nomeProd != null){
            for(Produto p : listaProdutos){
                if(nomeProd.equals(p.getNomeProduto())){
                    Double calc = p.getPrecoVenda() - p.getPrecoCompra();
                    p.setLucro(calc);
                    return p;
                }
            }
        }
        return null;
    }

    private void onClickAdicionarProduto(){
        this.BtnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto produtoAdicionar = salvaProduto();
                if(produtoAdicionar != null){
                    listaProdutos.add(produtoAdicionar);
                    Toast.makeText(MainActivity.this, "Produto salvo com sucesso", Toast.LENGTH_LONG).show();
                    LimparCampos();
                }else {
                    Toast.makeText(MainActivity.this, "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
                    LimparCampos();
                }
            }
        });

    }
    private void LimparCampos(){
        this.txtNome.setText("");
        this.txtPrecoCusto.setText("");
        this.txtPrecoVenda.setText("");
        this.txtPesquisarProd.setText("");
    }
    private Produto salvaProduto(){
        this.produto = new Produto();

        if(this.txtNome.getText().toString().isEmpty() == false){
            this.produto.setNomeProduto(this.txtNome.getText().toString());
        }else {
            return null;
        }
        if(this.txtPrecoCusto.getText().toString().isEmpty() == false){
            Double precoCompra = Double.parseDouble(this.txtPrecoCusto.getText().toString());
            this.produto.setPrecoCompra(precoCompra);
        }else {
            return null;
        }
        if(this.txtPrecoVenda.getText().toString().isEmpty() == false){
            Double precoVenda = Double.parseDouble(this.txtPrecoVenda.getText().toString());
            this.produto.setPrecoVenda(precoVenda);
        }else {
            return null;
        }

        return produto;
    }
}