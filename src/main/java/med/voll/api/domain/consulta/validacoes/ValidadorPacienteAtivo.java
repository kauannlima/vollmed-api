package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta){

        if (dadosAgendamentoConsulta.idMedico() == null){
            return;
        }


        var pacienteEstaAtivo = pacienteRepository.findAtivoById(dadosAgendamentoConsulta.idMedico());

        if (!pacienteEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendad com médico excluído");
        }

}
}
