package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;
import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {


    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta){

        var dataConsulta = dadosAgendamentoConsulta.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoFechamanto = dataConsulta.getHour() > 18;

        if (domingo||antesDaAberturaDaClinica||depoisDoFechamanto){
            throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica");
        }

    }
}
