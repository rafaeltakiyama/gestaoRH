CREATE TABLE IF NOT EXISTS tbareaatuacao(
	codArea integer primary key autoincrement,
	nomeArea TEXT
	);
CREATE UNIQUE INDEX idx_tbareaatuacao on tbareaatuacao(codArea);

CREATE TABLE IF NOT EXISTS tbcandidato(
	codCandidato integer primary key autoincrement,
  	areaAtuacao integer not null,
	nome TEXT,
	cpf TEXT,
	rg TEXT,
	data_nasc TEXT,
	email TEXT,
	endereco TEXT,
	escolaridade TEXT,
	instituicao_ensino TEXT,
	data_conclusao TEXT,
	FOREIGN KEY(areaAtuacao) REFERENCES tbareaatuacao(codArea)
	);
CREATE UNIQUE INDEX idx_tbcandidato on tbcandidato(codCandidato);


CREATE TABLE IF NOT EXISTS tbempresa(
	codEmpresa integer primary key autoincrement,
  	areaAtuacao integer not null,
	nomeEmpresa TEXT,
	enderecoEmpresa TEXT,
	emailEmpresa TEXT,
	FOREIGN KEY(areaAtuacao) REFERENCES tbareaatuacao(codArea)
	);
CREATE UNIQUE INDEX idx_tbempresa on tbempresa(codEmpresa);

CREATE TABLE IF NOT EXISTS tbvaga(
	codVaga integer primary key autoincrement,
  	empresaModel integer not null,
  	areaAtuacao integer not null,
	nomeVaga TEXT,
	requisitosVaga TEXT,
	localVaga TEXT,
	descriVaga TEXT,
	dataIniVaga TEXT,
	FOREIGN KEY(empresaModel) REFERENCES tbempresa(codEmpresa),
	FOREIGN KEY(areaAtuacao) REFERENCES tbareaatuacao(codArea)
	);
CREATE UNIQUE INDEX idx_tbvaga on tbvaga(codVaga);

CREATE TABLE IF NOT EXISTS tbeventoseletivo(
	codEventoSeletivo integer primary key autoincrement,
	nomeEventoSeletivo TEXT,
	descriEventoSeletivo TEXT,
	notaEventoSeletivo TEXT
	);
CREATE UNIQUE INDEX idx_tbeventoseletivo on tbeventoseletivo(codEventoSeletivo);


CREATE TABLE IF NOT EXISTS tbentrevista(
	codEntrevista integer primary key autoincrement,
  	eventoSeletivoModel integer not null,
	pretensaoSalarial TEXT,
	FOREIGN KEY(eventoSeletivoModel) REFERENCES tbeventoseletivo(codEvento)
	);
CREATE UNIQUE INDEX idx_tbentrevista on tbentrevista(codEntrevista);

CREATE TABLE IF NOT EXISTS tdselecao(
	codSelecao integer primary key autoincrement,
  	candidatoModel integer not null,
  	areaAtuacaoModel integer not null,
  	vagaModel integer not null,
  	empresaModel integer not null,
  	eventoSeletivoModel integer not null,
	FOREIGN KEY(candidatoModel) REFERENCES tbcandidato(codCandidato),
	FOREIGN KEY(areaAtuacaoModel) REFERENCES tbareaatuacao(codArea),
	FOREIGN KEY(vagaModel) REFERENCES tbvaga(codVaga),
	FOREIGN KEY(empresaModel) REFERENCES tbempresa(codEmpresa),
	FOREIGN KEY(eventoSeletivoModel) REFERENCES tbeventoseletivo(codEvento)
	);
CREATE UNIQUE INDEX idx_tdselecao on tdselecao(codSelecao);