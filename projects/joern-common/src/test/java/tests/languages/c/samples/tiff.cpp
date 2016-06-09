TiffStream::TiffStream()
{
    m_tif = NULL;


    m_inStream = NULL;
	m_outStream = NULL;
	m_ioStream = NULL;

	m_streamLength = 0;

	m_this = reinterpret_cast<thandle_t>(this);
}
