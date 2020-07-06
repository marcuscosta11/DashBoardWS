package com.mycompany.restfulexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 *
 * @author marcus.costa
 */
@Path("/message")
public class MessageRestService {        
    
    /*Retorna toda estações pluvio/acqua/agro/hidro/geo  
    em suas disponibilidades(operacional/desabilitada/inativa/suspeita) por UF - grafico de colunas */
    @GET
    @Path("/getJsonRedePcdsUF/")
    public Response getJsonRedePcdsUF() {
        String result = null;
        try {
            FileReader fr = new FileReader("lista_rede_pcds_uf.json");
            BufferedReader br = new BufferedReader(fr);                    
            while(br.ready()){
                result = br.readLine();
            }                
        } catch (Exception e) {
            e.printStackTrace();
        }                
        return Response.status(200).entity(result).build();
    }
        
    /*grafico de linha  -  inatividade das pcds*/
    @GET
    @Path("/getJsonInatividadePcds/")
    public Response getJsonInatividadePcds () {
        String result = null;
        try {
            FileReader fr = new FileReader("lista_rede_pcds_inativas.json");
            BufferedReader br = new BufferedReader(fr);                    
            while(br.ready()){
                result = br.readLine();
            }                
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonInatividadePcds: " + e.getMessage());
        }                
        return Response.status(200).entity(result).build();
    }
        
    @GET/*apresenta os valores totais para cada tipo de rede de pcds*/
    @Path("/getJsonTotalPcdsQuadroGeralRede/")
    public Response getJsonTotalPcdsQuadroGeralRede () {
        String result = null;
        try {
            FileReader fr = new FileReader("total_pcds_quadro_geral_rede.json");
            BufferedReader br = new BufferedReader(fr);                    
            while(br.ready()){
                result = br.readLine();
            }                
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonTotalPcdsQuadroGeralRede: " + e.getMessage());
        }                
        return Response.status(200).entity(result).build();
    }  
    
    
    
    
    private ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();            
    /*quadro geral*/
    @GET
    @Path(value = "/getJsonStatusPcdsQuadroGeralMaps/")
    public void getJsonStatusPcdsQuadroGeralMaps(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetJsonStatusPcdsQuadroGeralMaps());
            }
        });
    }

    private Response doGetJsonStatusPcdsQuadroGeralMaps() {
        String result = null;
        try {
            FileReader fr = new FileReader("status_pcds_quadro_geral.json");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                result = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonStatusPcdsQuadroGeralMaps: " + e.getMessage());
        }
        return Response.status(200).entity(result).build();
    }
    /*quadro geral*/
        
    /*pluvio*/
    @GET
    @Path(value = "/getJsonStatusPcdsPluvio/")
    public void getJsonStatusPcdsPluvio(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetJsonStatusPcdsPluvio());
            }
        });
    }
    private Response doGetJsonStatusPcdsPluvio() {
        String result = null;
        try {
            FileReader fr = new FileReader("status_pcds_pluvio.json");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                result = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonStatusPcdsPluvio: " + e.getMessage());
        }
        return Response.status(200).entity(result).build();
    }
    /*pluvio*/

    /*acqua*/
    @GET
    @Path(value = "/getJsonStatusPcdsAcqua/")
    public void getJsonStatusPcdsAcqua(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetJsonStatusPcdsAcqua());
            }
        });
    }
    private Response doGetJsonStatusPcdsAcqua() {
        String result = null;
        try {
            FileReader fr = new FileReader("status_pcds_acqua.json");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                result = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonStatusPcdsAcqua: " + e.getMessage());
        }
        return Response.status(200).entity(result).build();
    }
    /*acqua*/

    /*hidro*/
    @GET
    @Path(value = "/getJsonStatusPcdsHidro/")
    public void getJsonStatusPcdsHidro(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetJsonStatusPcdsHidro());
            }
        });
    }
    private Response doGetJsonStatusPcdsHidro() {
        String result = null;
        try {
            FileReader fr = new FileReader("status_pcds_hidro.json");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                result = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonStatusPcdsHidro" + e.getMessage());
        }
        return Response.status(200).entity(result).build();
    }
    /*hidro*/

    /*agro*/
    @GET
    @Path(value = "/getJsonStatusPcdsAgro/")
    public void getJsonStatusPcdsAgro(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetJsonStatusPcdsAgro());
            }
        });
    }
    private Response doGetJsonStatusPcdsAgro() {       
        String result = null;
        try {
            FileReader fr = new FileReader("status_pcds_agro.json");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                result = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonStatusPcdsAgro: " + e.getMessage());
        }
        return Response.status(200).entity(result).build();
    }
    /*agro*/

    /*geo*/
    @GET
    @Path(value = "/getJsonStatusPcdsGeo/")
    public void getJsonStatusPcdsGeo(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetJsonStatusPcdsGeo());
            }
        });
    }
    private Response doGetJsonStatusPcdsGeo() {
        String result = null;
        try {
            FileReader fr = new FileReader("status_pcds_geo.json");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                result = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonStatusPcdsGeo: " + e.getMessage());
        }
        return Response.status(200).entity(result).build();
    }
    /*geo*/        
    
    //Retorna uma lista com qtd de chip inativos por operadora
    @GET
    @Path(value = "/getJsonQtdChipOperadora/")
    public void getJsonQtdChipOperadora(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetJsonQtdChipOperadora());
            }
        });
    }
    private Response doGetJsonQtdChipOperadora() {
        String result = null;
        try {
            FileReader fr = new FileReader("lista_operadoras_chips_inativos.json");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                result = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonQtdChipOperadora: " + e.getMessage());
        }
        return Response.status(200).entity(result).build();
    }        
    
    
    //Retorna lista com pcds inativas por operadora - Vivo
    @GET
    @Path(value = "/getJsonPcdsInativasOperadora/")
    public void getJsonPcdsInativasOperadora(@Suspended final AsyncResponse asyncResponse) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                asyncResponse.resume(doGetgetJsonPcdsInativasOperadora());
            }
        });
    }
    private Response doGetgetJsonPcdsInativasOperadora() {
        String result = null;
        try {
            FileReader fr = new FileReader("lista_pcds_inativas_operadora_vivo.json");
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()){
                result = br.readLine();
            }
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonQtdChipOperadora: " + e.getMessage());
        }
        return Response.status(200).entity(result).build();
    }
    
    
//    teste covid-19
    @GET/*apresenta os valores totais para cada tipo de rede de pcds*/
    @Path("/getBaseCovid19/")
    public Response getBaseCovid19 () {
        String result = null;
        try {
            FileReader fr = new FileReader("base_corona_teste.json");
            BufferedReader br = new BufferedReader(fr);                    
            while(br.ready()){
                result = br.readLine();
            }                
        } catch (Exception e) {
            System.out.println(">>>DashboardWS.MessageRestService.printMessage() - getJsonTotalPcdsQuadroGeralRede: " + e.getMessage());
        }                
        return Response.status(200).entity(result).build();
    } 
//    teste
    
}




