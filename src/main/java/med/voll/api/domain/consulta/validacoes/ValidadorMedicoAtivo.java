package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;


@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta){

        if (dadosAgendamentoConsulta.idMedico() == null){
            return;
        }


        var medicoEstaAtivo = medicoRepository.findAtivoById(dadosAgendamentoConsulta.idMedico());

        if (!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendad com médico excluído");
        }

}
}
